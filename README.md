# Delivery App Kotlin

_Acá va un párrafo que describa lo que es el proyecto_

## Comenzando 🚀

_Bueno en este caso mostraré capturas de pantalla de las tres perspectivas de cada uno de los roles ( rol admin , rol cliente , rol repartidor)_

Mira **Pruebas** para conocer como son las vistas del proyecto.

### Pre-requisitos 📋

_Tener instalado Android Studio, conocer sobre kotlin, google maps, mercado pago, paypal, consultas a servidor Retrofit2_

```
. MinSdk =  23
. CompileSdk = 30
. TargetSdk = 30
. Gradle JDFK = corretto - 15 Amanzon Corretto version 15.0.2
. API = 27 Oreo 8.1
```

```
  //Ejemplo -> Interface Routes (Consulta a NodeJs)
    @GET("address/findByUser/{id_user}")
    fun getAddress(
        @Path("id_user") idUser: String,
        @Header("Authorization") token: String
    ): Call<ArrayList<Address>>

    @POST("address/create")
    fun create(
        @Body address: Address,
        @Header("Authorization") token: String
    ): Call<ResponseHttp>

```

## Ejecutando los diseños ⚙️
_* Vista Login y Registro_

<p align="center">
 <img src="https://i.postimg.cc/pdjdCFrk/1.png"/>
 <img src="https://i.postimg.cc/t4ZRRx3y/2.png"/>
</p>

_* En este paso procederé a mostrar las vistas del rol cliente (Cliente)_

<p align="center">
 <img src="https://i.postimg.cc/CMGmtP9p/11.png"/>
 <img src="https://i.postimg.cc/VNs8r0Md/3.png"/>
 <img src="https://i.postimg.cc/nLstGbRJ/3.png"/>
 <img src="https://i.postimg.cc/WbXLRbxV/4.png"/>
 <img src="https://i.postimg.cc/y8kGwhFh/5.png"/>
 <img src="https://i.postimg.cc/fbdrbwqJ/6.png"/>
 <img src="https://i.postimg.cc/D0vj51vX/7.png"/>
 <img src="https://i.postimg.cc/NMYpfRrz/8.png"/>
 <img src="https://i.postimg.cc/7hZ9SD91/9.png"/>
 <img src="https://i.postimg.cc/tC7DTqYp/10.png"/>
 <img src="https://i.postimg.cc/7Z2V3K3R/11.png"/>
 <img src="https://i.postimg.cc/q7HGj2Qv/12.png"/>
</p>

 
 * Pagar con Paypal

 <p align="center">
 
 <img src="https://i.postimg.cc/HknLRNZS/14.png"/>
 <img src="https://i.postimg.cc/cJ7Bj65M/15.png"/>

</p>


_* En este paso procederé a mostrar las vistas del rol admin (Restaurante)_

<p align="center">
 <img src="https://i.postimg.cc/VNs8r0Md/3.png"/>
 <img src="https://i.postimg.cc/CMGmtP9p/11.png"/>
 <img src="https://i.postimg.cc/gcLPZWwq/6.png"/>
 <img src="https://i.postimg.cc/sXZ0v3nM/7.png"/>
 <img src="https://i.postimg.cc/Gm7MK4VB/8.png"/>
 <img src="https://i.postimg.cc/1RwjS5nT/9.png"/>
 <img src="https://i.postimg.cc/9F2NQ5yf/10.png"/>
</p>

  * Asignar un repartidor desde rol admin
  
<p align="center">
 <img src="https://i.postimg.cc/Xqqh49R0/Screenshot-1644611816.png"/>
 <img src="https://i.postimg.cc/FFC8GnSF/Screenshot-1644611824.png"/>

</p>

_* En este paso procederé a mostrar las vistas del rol repartidor (Repartidor)_

<p align="center">
 <img src="https://i.postimg.cc/8CG0s224/Screenshot-1644611879.png"/>
 <img src="https://i.postimg.cc/7LNQzBDk/Screenshot-1644611887.png"/>
 <img src="https://i.postimg.cc/G2hgxkhs/Screenshot-1644611891.png"/>
 <img src="https://i.postimg.cc/ZR777CCs/Screenshot-1644611917.png"/>
</p>

## Autor ✒️

* **Paul Guillen Acuña** - *Mi Repositorio* - [PaulGuillen](https://github.com/PaulGuillen?tab=repositories)

## Licencia 📄

Este proyecto está bajo la Licencia (MIT License) - mira el archivo [LICENSE.md](LICENSE.md) para detalles
