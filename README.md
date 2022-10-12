Ubica Plus Bridge API
=====================
Package Structure
-
    com.ubicaplus.config - Contains the coniguration beans
    com.ubicaplus.controller - Contains the REST API Endpoint
    com.ubicaplus.dao - Contains the Data Access Object definition
    com.ubicaplus.impl - Contains the Implementation of the middleware service
    com.ubicaplus.model - Contains the data access models
    com.ubicaplus.payload - Contains the payloads or data transfer objects
    com.ubicaplus.service - Contains the SOAP Client business and REST API service Interface
    com.ubicaplus.utility - Contains all utilities
    com.webservice.ubicaplus - Contains all classess related to the SOAP Webservice auto generated from the SOAP WSDL
    org.xmlsoap.schemas.soap.encoding - Contains all schema definitions auto generated from the SOAP WSDL

Directory Structure
-
    src/main/java - Contains all application specific Java Classes and the hibernate configuration xml (hibernate.cfg.xml)
    src/main/resources - Contains the WSDL, and other properties files
    src/main/webapp - Contains all spring configuration xmls
    src/test - Contains the Test class

Files
-
    src/main/resources/wsdl/soapenc.xsd - Schema definition mentioned in the WSDL
    src/main/resources/wsdl/UbicaPlus.wsdl - Provider Webservice WSDL
    src/main/resources/application.properties - Spring application properties file
    src/main/resources/client-crypto.properties - Client crypto properties file required by the WSS4JOutInterceptor
    src/main/resources/ddl.sql - Necessary SQLs
    src/main/resources/equidadtes.jks - Public key
    src/main/resources/spring-context.xml - Spring context xml file for JAXWS WSSE security definition
    src/main/resources/users.txt - User list repository
    src/main/webapp/WEB-INF/applicationContext.xml - Spring application context
    src/main/webapp/WEB-INF/spring-servlet.xml - Spring servlet XML
    src/main/webapp/WEB-INF/web.xml - Spring Web XLM

Building the Bridge REST API Project
-
    Before build, confirm the following things:
    ___

    1. You have Java installed in your environment
    2. You have maven installed in your environment
    3. You have database connection available in your environment
    4. You have set the path of the users.txt properly in the src/main/resources/application.properties as a value of 
        ```userlist.file.location```
        Your file must be accessible
    5. You have put the database username, password and url properly that matches to your environment in: 
        ```src/main/webapp/WEB-INF/applicationContext.xml```

    ```
    <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource" destroy-method="close">
        <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
        <property name="url" value="jdbc:oracle:thin:@YOURDBHOST:YOURDBPORT:YOURDBSID_OR_SERVICENAME"/>
        <property name="username" value="YOURDBUSERNAME"/>
        <property name="password" value="YOURDBPASSWORD"/>
    </bean>
    ```

    From the root directory run: mvn clean install
    This will build the project war file
    After the successful build, the ubicaplus.war file will be available in the target/ folder

Deploy the Bridge REST API Project
-
    Copy the ubicaplus.war file from the target/ folder, paste it inside the webapps directory of a running apache tomcat
    Wait till your_tomcat_installation_directory/logs/catalina.out says something like this at the end, ```org.apache.catalina.startup.HostConfig.deployWAR Deployment of web application archive [...\apache-tomcat-...\webapps\ubicaplus.war] has finished in [....] ms```

    In default case, apache tomcat runs in: localhost at port: 8080

Consuming the Bridge REST API
-
    Consume the REST API from any REST client. Send a POST request to the Bridge API and get the response


Following is the URL to consume the bridge API:
___
    http://localhost:8080/ubicaplus/rest/call-provider-service
    ____
    
    Here:

    1. Your hostname. For example: http://localhost
    2. Your port number where tomcat is running. For example: 8080
    3. Bridge API Service Name: ubicaplus
    4. Context Path: rest
    5. Bridge API Endpoint: call-provider-service


Check the log
-
    The log file exists in your tomcat installation directory/log folder. You will see a file named: catalina.out

    To disable log, go to: tomcat installation directory/conf/logging.properties

    and comment the following line

    handlers = 1catalina.org.apache.juli.FileHandler, .....

    A sample Request Body is given below:
```
{
    "req_usuario": "307883",
    "req_password": "Equidad2208*",
    "codigoInformacion": "5632",
    "tipoIdentificacion": "1",
    "numeroIdentificacion": "262744",
    "primerApellido": "SEPULVEDA",
    "motivoConsulta": "24"
}
```
    For the above Bridge REST API request, the Bridge REST API response will be as follows:
```
{
    "tercero": {
        "tipoIdentificacion": "C.C.",
        "numeroIdentificacion": "262744",
        "ubicaPlusCifin": {
            "direcciones": {
                "direccion": [
                    {
                        "productoActivo": "NO",
                        "sectorEconomico": "1",
                        "primerReporte": "31/05/07",
                        "tipoUbicacion": "RES",
                        "noReportes": "1",
                        "direccion": "CL 7 # 5 - 57 ",
                        "ciudad": "GARZON ( HUILA ) ",
                        "ultimoReporte": "28/02/21",
                        "dirPos": "1"
                    }
                ]
            },
            "generoTercero": "HOMBRE",
            "mails": {
                "mail": [
                    {
                        "primerReporte": "30/11/19",
                        "noReportes": "1",
                        "ultimoReporte": "31/07/20",
                        "correo": "EVA_ASISTENTEPROCESOS@HOTMAIL.COM"
                    }
                ]
            },
            "celulares": {
                "celular": [
                    {
                        "productoActivo": "SI",
                        "sectorEconomico": "1",
                        "primerReporte": "13/09/22",
                        "celPos": "1",
                        "noReportes": "1",
                        "celular": "3017865306",
                        "ultimoReporte": "13/09/22"
                    },
                    {
                        "productoActivo": "SI",
                        "sectorEconomico": "1",
                        "primerReporte": "30/11/18",
                        "celPos": "2",
                        "noReportes": "2",
                        "celular": "3184320125",
                        "ultimoReporte": "31/12/21"
                    }
                ]
            },
            "telefonos": {
                "telefono": [
                    {
                        "productoActivo": "NO",
                        "sectorEconomico": "1",
                        "telPos": "1",
                        "primerReporte": "31/05/15",
                        "tipoUbicacion": "RES-LAB",
                        "telefono": "3243301",
                        "noReportes": "3",
                        "prefijo": "2",
                        "ciudad": "CALI ( VALLE ) ",
                        "ultimoReporte": "31/01/22"
                    },
                    {
                        "productoActivo": "SI",
                        "sectorEconomico": "1",
                        "telPos": "2",
                        "primerReporte": "05/09/07",
                        "tipoUbicacion": "RES-LAB",
                        "telefono": "7300178",
                        "noReportes": "7",
                        "prefijo": "2",
                        "ciudad": "PASTO ( NARIÑO ) ",
                        "ultimoReporte": "08/01/22"
                    },
                    {
                        "productoActivo": "NO",
                        "sectorEconomico": "1",
                        "telPos": "3",
                        "primerReporte": "31/10/09",
                        "tipoUbicacion": "RES-LAB",
                        "telefono": "7220127",
                        "noReportes": "4",
                        "prefijo": "2",
                        "ciudad": "PASTO ( NARIÑO ) ",
                        "ultimoReporte": "31/05/17"
                    },
                    {
                        "productoActivo": "NO",
                        "sectorEconomico": "2",
                        "telPos": "4",
                        "primerReporte": "31/01/10",
                        "tipoUbicacion": "RES-LAB",
                        "telefono": "7309216",
                        "noReportes": "1",
                        "prefijo": "2",
                        "ciudad": "PASTO ( NARIÑO ) ",
                        "ultimoReporte": "31/03/16"
                    },
                    {
                        "productoActivo": "NO",
                        "sectorEconomico": "1",
                        "telPos": "5",
                        "primerReporte": "31/10/09",
                        "tipoUbicacion": "RES-LAB",
                        "telefono": "7234671",
                        "noReportes": "1",
                        "prefijo": "2",
                        "ciudad": "PASTO ( NARIÑO ) ",
                        "ultimoReporte": "31/01/16"
                    },
                    {
                        "productoActivo": "NO",
                        "sectorEconomico": "1",
                        "telPos": "6",
                        "primerReporte": "31/05/07",
                        "tipoUbicacion": "RES-LAB",
                        "telefono": "7234671",
                        "noReportes": "1",
                        "prefijo": "4",
                        "ciudad": "MONTERIA ( CORDOBA ) ",
                        "ultimoReporte": "30/04/15"
                    }
                ]
            }
        },
        "lugarExpedicion": "GIRARDOT",
        "identificadorLinea": "97324",
        "codigoTipoIndentificacion": "1",
        "fechaExpedicion": "03/02/1955",
        "codigoDepartamento": "25",
        "codigoMunicipio": "307",
        "respuestaConsulta": "02",
        "nombre1": "RICARDO",
        "numeroInforme": "00126507560011617404",
        "nombreCiiu": "",
        "apellido1": "SEPULVEDA",
        "apellido2": "OVIEDO",
        "estado": "VIGENTE",
        "codigoCiiu": "0010",
        "rangoEdad": "Mas 75",
        "fecha": "08/10/2022",
        "hora": "05:00:51",
        "entidad": "SCOO EQUIDAD SCS                   ",
        "nombreTitular": "SEPULVEDA       OVIEDO        RICARDO       ",
        "estadoTitular": ""
    }
}
```