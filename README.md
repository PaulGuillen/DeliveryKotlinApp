# Delivery App Kotlin

_Al dia de hoy las APIS DE CONSUMO COMO MERCADO PAGO Y PAYPAL ESTAN DESACTUALZIADOS POR PARTE DEL PROYECTO TENER EN CUENTA ESO.

_Proyecto base para que en un futuro cualquiera de la comunidad pueda reutilizar el código y les sirva de base para sus proyectos._

## Comenzando 🚀
_Para comenzar debes tener instalado PostgreSql(PgAdmin), descargar y ejecutar el backend [BackendApp](https://github.com/PaulGuillen/BackendDeliveryKotlin)._

_Mira **Creando usuario principal** para ver que usuario pueden utilizar para hacer sus pruebas._

### Pre-requisitos 📋

_Tener instalado Android Studio, conocer sobre kotlin, google maps, mercado pago, paypal, consultas a servidor Retrofit, socketIO en NodeJS._

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

## Creando usuario principal 🖇️

_Ejecutar el backend, antes de haber ejecutado la aplicacion en android studio._

_Crear en pgadmin un server llamado "Delivery" dentro del server una base de datos llamada "delivery_db"._


<p align="center">
 <img src="https://i.postimg.cc/9Q9VdBj2/estrcutra.png"/>
</p>

_Además el usuario que has creado desde android studio solo tendra un rol por defecto el cual es usuario, tienes que modifcarlo en PGADMIN en la "tabla user_has_roles", deberia quedar así._
  
 <p align="center">
 <img src="https://i.postimg.cc/7YFrZTJW/roles.png"/>
</p>

## Ejecutando los diseños ⚙️
_* Vista Login y Registro_

_Bueno en este caso mostraré capturas de pantalla de las tres perspectivas de cada uno de los roles ( rol admin , rol cliente , rol repartidor)._


<p align="center">
 <img src="https://i.postimg.cc/pdjdCFrk/1.png"/>
 <img src="https://i.postimg.cc/t4ZRRx3y/2.png"/>
</p>

_* En este paso procederé a mostrar las vistas del rol cliente (Cliente)._

<p align="center">
 <img src="https://i.postimg.cc/Hxxh2p7M/5.png"/>
 <img src="https://i.postimg.cc/mgYJZpsP/3.png"/>
 <img src="https://i.postimg.cc/nLstGbRJ/3.png"/>
 <img src="https://i.postimg.cc/WbXLRbxV/4.png"/>
 <img src="https://i.postimg.cc/y8kGwhFh/5.png"/>
 <img src="https://i.postimg.cc/fbdrbwqJ/6.png"/>
 <img src="https://i.postimg.cc/D0vj51vX/7.png"/>
 <img src="https://i.postimg.cc/NMYpfRrz/8.png"/>
 <img src="https://i.postimg.cc/7hZ9SD91/9.png"/>
 <img src="https://i.postimg.cc/wjwPsy1z/10.png"/>
 <img src="https://i.postimg.cc/7Z2V3K3R/11.png"/>
 <img src="https://i.postimg.cc/bJtFMm3Y/12.png"/>
</p>

 
 * Pagar con Paypal.

 <p align="center">
  
 <img src="https://i.postimg.cc/yYBrQX9B/14.png"/>
 <img src="https://i.postimg.cc/cJ7Bj65M/15.png"/>

</p>


_* En este paso procederé a mostrar las vistas del rol admin (Restaurante)._

<p align="center">
 <img src="https://i.postimg.cc/mgYJZpsP/3.png"/>
 <img src="https://i.postimg.cc/CMGmtP9p/11.png"/>
 <img src="https://i.postimg.cc/gcLPZWwq/6.png"/>
 <img src="https://i.postimg.cc/QMRfpps2/7.png"/>
 <img src="https://i.postimg.cc/Gm7MK4VB/8.png"/>
 <img src="https://i.postimg.cc/1RwjS5nT/9.png"/>
 <img src="https://i.postimg.cc/ZqKWVgY3/10.png"/>
</p>

  * Asignar un repartidor desde rol admin.
  
<p align="center">

 <img src="https://i.postimg.cc/1XzsDhy7/Screenshot-1644611816.png"/>
 <img src="https://i.postimg.cc/FFC8GnSF/Screenshot-1644611824.png"/>

</p>

_* En este paso procederé a mostrar las vistas del rol repartidor (Repartidor)._

<p align="center">
 <img src="https://i.postimg.cc/8CG0s224/Screenshot-1644611879.png"/>
 <img src="https://i.postimg.cc/7LNQzBDk/Screenshot-1644611887.png"/>
 <img src="https://i.postimg.cc/G2hgxkhs/Screenshot-1644611891.png"/>
 <img src="https://i.postimg.cc/ZR777CCs/Screenshot-1644611917.png"/>
</p>

_En este video se mostrará las demas funcionalidades de la app._

[AppDeliveryKotlin-Video](https://user-images.githubusercontent.com/43099030/164571188-cec0be71-1f42-4898-a55e-36c4bccd873e.mp4)

---

## Autor ✒️

* **Paul Guillen Acuña** - *Mi Repositorio* - [PaulGuillen](https://github.com/PaulGuillen?tab=repositories)
