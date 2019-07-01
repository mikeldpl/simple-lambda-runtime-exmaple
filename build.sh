#!/usr/bin/env bash

mvn clean install

cd ./target

docker run --rm -v $(pwd):/workdir \
oracle/graalvm-ce:1.0.0-rc16 /bin/bash -c "cd /workdir && \
                    native-image --no-server --enable-url-protocols=http --static --no-fallback -jar lambda-native-1.0-SNAPSHOT.jar"

#                    -Djava.net.preferIPv4Stack=true \
#                    -H:ReflectionConfigurationFiles=/working/reflect.json \
#                    -H:+ReportUnsupportedElementsAtRuntime\
#                    --no-server

mv lambda-native-1.0-SNAPSHOT bootstrap

zip -j lambda-native.zip bootstrap
