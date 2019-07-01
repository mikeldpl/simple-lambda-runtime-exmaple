#!/usr/bin/env bash

aws lambda update-function-code --function-name native-demo-lambda --zip-file fileb://target/lambda-native.zip