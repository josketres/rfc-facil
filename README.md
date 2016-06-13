
![app-doctor](https://raw.githubusercontent.com/josketres/rfc-facil/master/art/logo.png)

Libreria para calcular el Registro Federal de Contribuyentes en México (RFC) en Java.

[![Build Status](https://travis-ci.org/josketres/rfc-facil.svg?branch=master)](https://travis-ci.org/josketres/rfc-facil)

Uso
---
Calcular el rfc de una persona física es muy sencillo:
```java
// Josué Zarzosa de la Torre nacido el 5 de Agosto de 1987
Rfc rfc = new Rfc.Builder()
            .name("Josué")
            .firstLastName("Zarzosa")
            .secondLastName("de la Torre")
            .birthday(5, 8, 1987)
            .build();

// se puede obtener el rfc completo
print(rfc.toString());        // ZATJ870805CK6

// se pueden obtener partes del rfc
print(rfc.tenDigitsCode);     // ZATJ870805
print(rfc.homoclave);         // CK
print(rfc.verificationDigit); // 6
```

Calcular el rfc de una persona moral:
```java
Rfc rfc = new Rfc.Builder()
        .legalName("Sonora Industrial Azucarera, S. de R. L.")
        .creationDate(29, 11, 1982)
        .build();
        
// se puede obtener el rfc completo
print(rfc.toString());        // SIA-821129LS8

// se pueden obtener partes del rfc
print(rfc.tenDigitsCode);     // SIA-821129
print(rfc.homoclave);         // LS
print(rfc.verificationDigit); // 8
```

Download
--------

Baja directamente [el JAR de la versión más actual][2] o declara la dependencia vía Maven:
```xml
<dependency>
  <groupId>com.josketres</groupId>
  <artifactId>rfcfacil</artifactId>
  <version>1.1.0</version>
</dependency>
```
o con Gradle:
```groovy
compile 'com.josketres:rfcfacil:1.1.0'
```

Fuentes
---
Esta librería se basa en documentación oficial obtenida por medio del IFAI (Instituto Federal de Acceso a la Información). El documento puede ser consultado en el sitio de [INFOMEX](https://www.infomex.org.mx/gobiernofederal/moduloPublico/moduloPublico.action) con el folio `0610100135506`.


Cabe advertir que sólo la Secretaría de Hacienda y Crédito Público, a través del Servicio de Administración Tributaria, es la única instancia que oficialmente asigna las claves de RFC a los contribuyentes que así lo soliciten, a partir de la aplicación de este procedimiento a la base de datos del Padrón de Contribuyentes, con la finalidad de identificar homonimias y evitar la duplicidad de registros.

### En otros Lenguajes
- Ruby [acrogenesis/rfc_facil](https://github.com/acrogenesis/rfc_facil)
- .NET [migsalazar/RfcFacil](https://github.com/migsalazar/RfcFacil)

License
-------

    Copyright 2014 Josué Zarzosa de la Torre

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 [2]: https://search.maven.org/remote_content?g=com.josketres&a=rfcfacil&v=LATEST
