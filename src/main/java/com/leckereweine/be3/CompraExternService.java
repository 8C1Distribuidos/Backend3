package com.leckereweine.be3;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class CompraExternService {

    private static final String BD_URL = "http://25.4.107.19:9081/";
    private static final String BANCO_URL = "http://localhost:8080/";


    public static Compra postCompra(CompraParaBD compra){
        Gson gson = new Gson();
        String jsonString = gson.toJson(compra);
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BD_URL + "tickets/"))
                /*.header("Content-Type", "application/json")*/
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        /*try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Compra comprita = gson.fromJson(response.body(), Compra.class);
            System.out.println(response.body());
            return comprita;
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
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

    public static List<Compra> getHistorialCompras(Usuario usuario) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(usuario);
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BD_URL + "tickets/find/"))
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                /*.header("Content-Type", "application/json")*/
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
    }

    public static List<Producto> getInfoProductos(List<Integer> productos) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(productos);
        System.out.println(jsonString);
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BD_URL + "productos/"))
                /*.header("Content-Type", "application/json")*/
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Type productoListType = new TypeToken<ArrayList<Producto>>(){}.getType();
            List<Producto> productosNuevos = gson.fromJson(response.body(), productoListType);
            System.out.println(response.body());
            return productosNuevos;
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

    public static boolean checkCompra(Compra compra) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(compra);
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BANCO_URL + "cuenta/compra"))
                /*.header("Content-Type", "application/json")*/
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Boolean possible = gson.fromJson(response.body(), Boolean.class);
            System.out.println(response.body());
            return possible;
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Ciudad> getCiudades(){
        Gson gson = new Gson();
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BD_URL + "ciudades"))
                /*.header("Content-Type", "application/json")*/
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Type productoListType = new TypeToken<ArrayList<Ciudad>>(){}.getType();
            List<Ciudad> ciudades = gson.fromJson(response.body(), productoListType);
            System.out.println(response.body());
            return ciudades;
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
