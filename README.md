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

``` bash

```

4. 



<hr />
Pas Apicella [papicella at pivotal.io] is an Advisory Platform Architect at Pivotal Australia