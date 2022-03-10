# Java AppCore
## _Aplicación Java Core que conecta con la APIREST de Django_


Desarrollada con Java en su versión 8, con el IDE Netbeans.

## Funcionalidades
- Conectar con la Api REST de Django
- Mapear los DTO para interacturar con la API
- Obtener la información del documento para su firma

La Api de Java, permite centralizar el trabajo para las aplicaciones de java en las interfaces, ya que la api de Java tiene a disponiblidad los metodos que liberó la API de Django.


## Librerias

Se utilizadon las siguientes librerias para el desarrollo de la API:

- [ItexPDF](https://itextpdf.com/es) - Lectura de PDF
- [Gson](https://github.com/google/gson) - Mapeo de Json a Objetos

## Instalación

Requiere [Java 8](https://www.java.com/es/download/ie_manual.jsp) para ejecutar.

Archivo de configuración [parametros.properties](https://github.com/Arquitectura-de-Software-UFPS-2022-I/Java-AppCore/blob/main/src/resources/parametros.properties).

```properties
BASE = http://52.240.59.172:8000
```

## Modelos

Dentro del paquete models.

| DTO | Descripción |
| ------ | ------ |
| FileDto | Modelo generico para almacenar la información de los archivos que estásn subidos |
| FirmaDto | Modelo que retorna la api de validar la firma, para verificar su autenticidad |
| SignatureRequestDto | Solicitudes para firmar documentos |
| SignatureRequestUserDto | Solicitudes de usuarios para firmar documento asignado |
| UserDto | Modelo de cuentas de usuarios |

## Servicios

Dentro del paquete services.impl

| Service | Descripción |
| ------ | ------ |
| ApiService | Servicio centralizado para obtener los subservicios ofrecidos por la api para administrar los DTO |

## Autor(es)

**Omar Ramón Montes - Desarrollador**

-   <https://github.com/1151704>

## Institución Académica

**[Programa de Ingeniería de Sistemas]** de la **[Universidad Francisco de Paula Santander]**

[Programa de Ingeniería de Sistemas]: https://ingsistemas.cloud.ufps.edu.co/
[Universidad Francisco de Paula Santander]: https://ww2.ufps.edu.co/

## Licencia
El código fuente se publica bajo la [MIT License](https://github.com/Arquitectura-de-Software-UFPS-2022-I/Java-AppCore/blob/main/LICENSE).