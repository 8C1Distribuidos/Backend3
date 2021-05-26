package com.leckereweine.be3;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import springfox.documentation.spring.web.json.Json;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CompraExternService {
    static class LocalDateAdapter implements JsonSerializer<LocalDateTime> {

        public JsonElement serialize(LocalDateTime date, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // "yyyy-mm-dd"
        }
    }



    //private static final String BD_URL = "http://25.16.129.2:9081/"; //El de luisrard
    private static final String BD_URL = "http://25.4.107.19:9081/";
    private static final String BANCO_URL = "http://localhost:8081/";


    public static CompraParaBD postCompra(CompraParaBD compra){
        Gson gson = new GsonBuilder()

                .registerTypeAdapter(LocalDateTime.class, new LocalDateAdapter())
                .create();
        String jsonString = gson.toJson(compra);
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BD_URL + "tickets/"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //Compra comprita = gson.fromJson(response.body(), Compra.class);
            System.out.println(response.body());
            return compra; //commented
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //return compra;
        return null;
    }

    /*public static List<Compra> getHistorialCompras(int id_usuario) {
        Gson gson = new Gson();
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BD_URL + "tickets/find/?id=" + id_usuario))

                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Type compraListType = new TypeToken<ArrayList<Compra>>(){}.getType();
            List<Compra> compras = gson.fromJson(response.body(), compraListType);
            System.out.println(response.body());
            return compras;
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    public static List<CompraBD> getHistorialCompras(Usuario usuario) {

        Gson gson = new GsonBuilder()

                .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                            throws JsonParseException {
                        return LocalDateTime.parse(json.getAsString(),
                                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:s").withLocale(Locale.ENGLISH));
                        //Por favor funciona ^-^
                    }
                })
                .create();

        String jsonString = gson.toJson(usuario);
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BD_URL + "tickets/client-history?idUser=" + usuario.getId_usuario()))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Type compraListType = new TypeToken<ArrayList<Compra>>(){}.getType();

            CompraBD [] arregloC = gson.fromJson(response.body(), CompraBD[].class);

            if(arregloC != null){
                List<CompraBD> compras = Arrays.asList(arregloC);

                System.out.println(response.body());
                return compras;
            }


        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Producto> getInfoProductos(List<Integer> productos) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(productos);
        System.out.println(jsonString);
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://25.98.13.19:5555/api/product/GetList"))
                 .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Type productoListType = new TypeToken<ArrayList<Producto>>(){}.getType();

            Producto[] arregloP = gson.fromJson(response.body(), Producto [].class);

            if(arregloP != null){
                List<Producto> productosNuevos = Arrays.asList(arregloP);


                System.out.println(response.body());
                return productosNuevos;
            }


        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Usuario getUser(int id){
        Gson gson = new Gson();
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://25.4.107.19:8080/users/find?id=" + id))
                /*.header("Content-Type", "application/json")*/
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Usuario usuario = gson.fromJson(response.body(), Usuario.class);
            System.out.println(response.body());
            return usuario;
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int checkCompra(Compra compra) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(compra);
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BANCO_URL + "cuenta/compra"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 422){
                return 1;
            }else if(response.statusCode() == 404){
                return 2;
            }else if(response.statusCode() == 400){
                return 3;
            }
            Boolean possible = gson.fromJson(response.body(), Boolean.class);
            System.out.println(response.body());
            return 0;
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 5;
    }

    public static List<Ciudad> getCiudades(){
        Gson gson = new Gson();
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BD_URL + "/cities"))
                /*.header("Content-Type", "application/json")*/
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Type productoListType = new TypeToken<ArrayList<Ciudad>>(){}.getType();

            Ciudad[] arregloC = gson.fromJson(response.body(), Ciudad[].class);

            if(arregloC != null){
                List<Ciudad> ciudades = Arrays.asList(arregloC);

                System.out.println(response.body());
                return ciudades;
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int enviarLista(List<Producto> listaProductos){
        Gson gson = new Gson();
        String jsonString = gson.toJson(listaProductos);
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://25.98.13.19:5555/api/product/UpdateStock"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            /*Type productoListType = new TypeToken<ArrayList<Producto>>(){}.getType();

            Producto[] arregloP = gson.fromJson(response.body(), Producto [].class);

            if(arregloP != null){
                List<Producto> productosNuevos = Arrays.asList(arregloP);


                System.out.println(response.body());
                return productosNuevos;
            }*/
            System.out.println(response);
            if(response.statusCode() == 404){
                return 1;
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;

    }
}
