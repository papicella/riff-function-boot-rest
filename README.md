# Spring Boot Function deployed using riff

## What is riff

riff is an Open Source platform for building and running Functions, Applications, and Containers on Kubernetes. For more information visit the riff home page as follows (https://projectriff.io/)

## Steps

1. Ensure you have installed riff. Use the guide below to get started with riff 

https://projectriff.io/docs/v0.5/getting-started

``` bash
papicella@papicella:~$ riff --version
riff version 0.5.0 (f96cf2f5ca6fddfaf4716c0045f5f142da2d3828)
```

2. Ensure you have installed riff into a k8s cluster of your choice. I am using GKE cluster which you can 
also do by following this guide

https://projectriff.io/docs/v0.5/getting-started/gke

You will be ready once you run this command showing the status of the install

``` bash
papicella@papicella:~$ riff doctor
NAMESPACE     STATUS
default       ok
riff-system   ok

RESOURCE                                    NAMESPACE     NAME       READ      WRITE
configmaps                                  riff-system   builders   allowed   n/a
configmaps                                  default       *          allowed   allowed
secrets                                     default       *          allowed   allowed
pods                                        default       *          allowed   n/a
pods/log                                    default       *          allowed   n/a
applications.build.projectriff.io           default       *          allowed   allowed
containers.build.projectriff.io             default       *          allowed   allowed
functions.build.projectriff.io              default       *          allowed   allowed
deployers.core.projectriff.io               default       *          missing   missing
processors.streaming.projectriff.io         default       *          missing   missing
streams.streaming.projectriff.io            default       *          missing   missing
inmemorygateways.streaming.projectriff.io   default       *          missing   missing
kafkagateways.streaming.projectriff.io      default       *          missing   missing
pulsargateways.streaming.projectriff.io     default       *          missing   missing
adapters.knative.projectriff.io             default       *          allowed   allowed
deployers.knative.projectriff.io            default       *          allowed   allowed
```

3. In this demo we will use this GitHub repo as the source for the function we are creating. That is done 
as follows

**riff function create riff-country-service --handler getCountryDetails --git-repo https://github.com/papicella/riff-function-boot-rest.git --tail**

``` bash
papicella@papicella:~$ riff function create riff-country-service --handler getCountryDetails --git-repo https://github.com/papicella/riff-function-boot-rest.git --tail
Created function "riff-country-service"
Waiting for function "riff-country-service" to become ready...
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[prepare]: prepare:fetch.go:66: Successfully cloned "https://github.com/papicella/riff-function-boot-rest.git" @ "35a83c2ab2695a1c14022d3082c01697340a883f" in path "/workspace"
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]: Cloud Foundry OpenJDK Buildpack 1.2.12
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:   OpenJDK JDK 11.0.6: Contributing to layer
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     Reusing cached download from buildpack
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     Expanding to /layers/org.cloudfoundry.openjdk/openjdk-jdk
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     Writing JAVA_HOME to build
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     Writing JDK_HOME to build
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:   OpenJDK JRE 11.0.6: Contributing to layer
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     Reusing cached download from buildpack
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     Expanding to /layers/org.cloudfoundry.openjdk/openjdk-jre

...

default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]: [INFO] Replacing main artifact with repackaged archive
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]: [INFO] ------------------------------------------------------------------------
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]: [INFO] BUILD SUCCESS
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]: [INFO] ------------------------------------------------------------------------
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]: [INFO] Total time:  29.524 s
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]: [INFO] Finished at: 2020-02-20T22:38:01Z
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]: [INFO] ------------------------------------------------------------------------
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:   Removing source code
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]: Java Function Buildpack 0.2.1
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:   Java getCountryDetails: Contributing to layer
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     Writing SPRING_CLOUD_FUNCTION_DEFINITION to launch
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     Writing SPRING_CLOUD_FUNCTION_LOCATION to launch
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:   riff Streaming HTTP Adapter 0.5.0: Contributing to layer
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     Reusing cached download from buildpack
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     Expanding to /layers/io.projectriff.java/streaming-http-adapter
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:   riff Java Invoker 0.2.0: Contributing to layer
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     Reusing cached download from buildpack
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     Expanding to /layers/io.projectriff.java/riff-invoker-java
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:   Process types:
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     function:           streaming-http-adapter java -cp /layers/io.projectriff.java/riff-invoker-java $JAVA_OPTS org.springframework.boot.loader.JarLauncher
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     streaming-function: java -cp /layers/io.projectriff.java/riff-invoker-java $JAVA_OPTS org.springframework.boot.loader.JarLauncher
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[build]:     web:                streaming-http-adapter java -cp /layers/io.projectriff.java/riff-invoker-java $JAVA_OPTS org.springframework.boot.loader.JarLauncher
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding layer 'launcher'
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding layer 'org.cloudfoundry.openjdk:class-counter'
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding layer 'org.cloudfoundry.openjdk:java-security-properties'
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding layer 'org.cloudfoundry.openjdk:jvmkill'
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding layer 'org.cloudfoundry.openjdk:link-local-dns'
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding layer 'org.cloudfoundry.openjdk:memory-calculator'
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding layer 'org.cloudfoundry.openjdk:openjdk-jre'
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding layer 'org.cloudfoundry.openjdk:security-provider-configurer'
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding layer 'io.projectriff.java:java-function'
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding layer 'io.projectriff.java:riff-invoker-java'
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding layer 'io.projectriff.java:streaming-http-adapter'
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding 1/1 app layer(s)
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding layer 'config'
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: *** Images (sha256:e722f32df357b177586d4862d1fa126cacac833452d00965367a64dc9dcdb13d):
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]:       gcr.io/fe-papicella/riff-country-service
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]:       gcr.io/fe-papicella/riff-country-service:b1.20200220.223712
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding cache layer 'org.cloudfoundry.openjdk:openjdk-jdk'
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding cache layer 'org.cloudfoundry.buildsystem:build-system-application'
default/riff-country-service-function-7cw7f-build-1-xxhz4-build-pod[export]: Adding cache layer 'org.cloudfoundry.buildsystem:build-system-cache'
Function "riff-country-service" is ready
```

4. Create a knative deployer as shown below

**riff knative deployer create knative-riff-country-service --function-ref riff-country-service --ingress-policy External --tail**

``` bash
papicella@papicella:~$ riff knative deployer create knative-riff-country-service --function-ref riff-country-service --ingress-policy External --tail
Created deployer "knative-riff-country-service"
Waiting for deployer "knative-riff-country-service" to become ready...
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: Container memory limit unset. Configuring JVM for 1G container.
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: Calculated JVM Memory Configuration: -XX:MaxDirectMemorySize=10M -XX:MaxMetaspaceSize=78797K -XX:ReservedCodeCacheSize=240M -Xss1M -Xmx457778K (Head Room: 0%, Loaded Class Count: 11498, Thread Count: 250, Total Memory: 1073741824)
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:   .   ____          _            __ _ _
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:   '  |____| .__|_| |_|_| |_\__, | / / / /
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:  =========|_|==============|___/=/_/_/_/
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:  :: Spring Boot ::        (v2.2.4.RELEASE)
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: 22:41:08.495 [main] INFO  i.p.invoker.main.EntryPoint - Starting EntryPoint on knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5 with PID 44 (/layers/io.projectriff.java/riff-invoker-java/BOOT-INF/classes started by cnb in /workspace)
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: 22:41:08.500 [main] INFO  i.p.invoker.main.EntryPoint - No active profile set, falling back to default profiles: default
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: 22:41:10.442 [main] INFO  o.s.c.f.d.FunctionDeployerConfiguration - Deploying archive: /workspace
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:   .   ____          _            __ _ _
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:   '  |____| .__|_| |_|_| |_\__, | / / / /
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:  =========|_|==============|___/=/_/_/_/
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:  :: Spring Boot ::        (v2.2.4.RELEASE)
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]:
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: 2020-02-20 22:41:11.409  INFO 44 --- [           main] o.s.boot.SpringApplication               : Starting application on knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5 with PID 44 (started by cnb in /workspace)
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: 2020-02-20 22:41:11.417  INFO 44 --- [           main] o.s.boot.SpringApplication               : No active profile set, falling back to default profiles: default
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: 2020-02-20 22:41:12.453  INFO 44 --- [           main] o.s.boot.SpringApplication               : Started application in 1.737 seconds (JVM running for 6.083)
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: 22:41:12.460 [main] INFO  o.s.c.f.d.FunctionArchiveDeployer - Application context for archive 'file:/workspace/' is created.
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: 22:41:12.492 [main] INFO  o.s.c.f.d.FunctionArchiveDeployer - Discovered functions in deployed application context: {getCountryDetails=pas.au.riff.demo.RiffFunctionBootRestApplication$$Lambda$462/0x00000001004f4840@7c46c9c3, functionRouter=org.springframework.cloud.function.context.config.RoutingFunction@7197b07f}
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: 22:41:12.503 [main] INFO  o.s.c.f.d.FunctionArchiveDeployer - Registering function 'getCountryDetails' of type 'java.util.function.Function<java.lang.String, java.lang.String>' in FunctionRegistry.
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: 22:41:12.514 [main] INFO  o.s.c.f.d.FunctionArchiveDeployer - Registering function 'functionRouter' of type 'class org.springframework.cloud.function.context.config.RoutingFunction' in FunctionRegistry.
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: 22:41:12.521 [main] INFO  o.s.c.f.d.FunctionDeployerConfiguration - Successfully deployed archive: /workspace
default/knative-riff-country-service-deployer-q8l75-mj27n-deploymelgxb5[user-container]: 22:41:12.626 [main] INFO  i.p.invoker.main.EntryPoint - Started EntryPoint in 4.95 seconds (JVM running for 6.256)
Deployer "knative-riff-country-service" is ready
```

5. Let's inspect what functions and deployers we have just created as follows

``` bash
papicella@papicella:~$ riff functions list
NAME                   LATEST IMAGE                                                                                                       ARTIFACT    HANDLER             INVOKER   STATUS   AGE
riff-country-service   gcr.io/fe-papicella/riff-country-service@sha256:e722f32df357b177586d4862d1fa126cacac833452d00965367a64dc9dcdb13d   <empty>     getCountryDetails   <empty>   Ready    5m15s
square                 gcr.io/fe-papicella/square@sha256:f64ed02b67bda95f8508e7d570ae42a5ba6d3aa8e6ef4a57f013960159134b32                 square.js   <empty>             <empty>   Ready    6d21h

papicella@papicella:~$ riff knative deployer list
NAME                           TYPE       REF                    URL                                                       STATUS   AGE
knative-riff-country-service   function   riff-country-service   http://knative-riff-country-service.default.example.com   Ready    92s
knative-square                 function   square                 http://knative-square.default.example.com                 Ready    6d21h
```

6. Create a script to invoke the function service as shown below

``` bash
export INGRESS_IP=$(kubectl get svc envoy-external --namespace projectcontour --output 'jsonpath={.status.loadBalancer.ingress[0].ip}')
export HOST=knative-riff-country-service.default.example.com

echo "Host: $HOST "
echo "Function IP Address: $INGRESS_IP "

echo ""
echo "Invoking riff-country-service now ..."
echo ""

http POST http://$INGRESS_IP 'Content-Type: application/json' 'Host: knative-riff-country-service.default.example.com' --json <<< AU
```

7. Invoke the function as follows. I use https://httpie.org (httpie) as it's much easier then curl and it runs on windows, linux and mac

``` http request
papicella@papicella:~$ ./invoke-riff-country-service.sh
Host: knative-riff-country-service.default.example.com
Function IP Address: 34.69.25.24

Invoking riff-country-service now ...

HTTP/1.1 200 OK
content-encoding: gzip
content-type: text/plain; charset=utf-8
date: Thu, 20 Feb 2020 22:48:57 GMT
server: envoy
transfer-encoding: chunked
vary: Accept-Encoding
x-envoy-upstream-service-time: 13876

{
    "alpha2Code": "AU",
    "alpha3Code": "AUS",
    "altSpellings": [
        "AU"
    ],
    "area": 7692024.0,
    "borders": [],
    "callingCodes": [
        "61"
    ],
    "capital": "Canberra",
    "cioc": "AUS",
    "currencies": [
        {
            "code": "AUD",
            "name": "Australian dollar",
            "symbol": "$"
        }
    ],
    "demonym": "Australian",
    "flag": "https://restcountries.eu/data/aus.svg",
    "gini": 30.5,
    "languages": [
        {
            "iso639_1": "en",
            "iso639_2": "eng",
            "name": "English",
            "nativeName": "English"
        }
    ],
    "latlng": [
        -27.0,
        133.0
    ],
    "name": "Australia",
    "nativeName": "Australia",
    "numericCode": "036",
    "population": 24117360,
    "region": "Oceania",
    "regionalBlocs": [],
    "subregion": "Australia and New Zealand",
    "timezones": [
        "UTC+05:00",
        "UTC+06:30",
        "UTC+07:00",
        "UTC+08:00",
        "UTC+09:30",
        "UTC+10:00",
        "UTC+10:30",
        "UTC+11:30"
    ],
    "topLevelDomain": [
        ".au"
    ],
    "translations": {
        "br": "Austrália",
        "de": "Australien",
        "es": "Australia",
        "fa": "استرالیا",
        "fr": "Australie",
        "hr": "Australija",
        "it": "Australia",
        "ja": "オーストラリア",
        "nl": "Australië",
        "pt": "Austrália"
    }
}
```

8. Observe using "kubectl get pods" that a pod is created to invoke the function for us. Eventually riff with Knative will scale the function service back to 0 once it is no longer being accessed
 
``` bash 
Every 2.0s: kubectl get pods                                                                                                                                                                               papicella: Fri Feb 21 09:49:03 2020

NAME                                                              READY   STATUS      RESTARTS   AGE
knative-riff-country-service-deployer-q8l75-mj27n-deploymec6wzt   2/2     Running     0          20s
riff-country-service-function-7cw7f-build-1-xxhz4-build-pod       0/1     Completed   0          11m
square-function-rcfzx-build-1-s4tpk-build-pod                     0/1     Completed   0          6d21h
```

Our function pod is no longer running about one minute later

``` bash
Every 2.0s: kubectl get pods                                                                                                                                                                               papicella: Fri Feb 21 09:50:51 2020

NAME                                                          READY   STATUS      RESTARTS   AGE
riff-country-service-function-7cw7f-build-1-xxhz4-build-pod   0/1     Completed   0          13m
square-function-rcfzx-build-1-s4tpk-build-pod                 0/1     Completed   0          6d21h
```

# More information

https://projectriff.io/

<hr />
Pas Apicella [papicella at pivotal.io] is an Advisory Platform Architect at Pivotal Australia