#### Owner Tim Whittake => timothy.whittaker@datarobot.com

## requirements 

* java 11

*** building on your own? 

Before packaging this with maven, install `predictors.jar` located in the lib folder with 

`mvn install:install-file -Dfile=lib/predictors.jar -DartifactId=drum -DgroupId=com.datarobot -Dversion=1.0.0 -Dpackaging=jar`

Package this up via `mvn package`, and move `target/custom-model-0.1.0.jar` to `model` folder (already there if you don't want to package this).  

### running without docker

you need to build and install branch `tim/java-unstructured-experiment` of [www.github.com/datarobot-user-models](DRUM). 

`drum server --code-dir ./model  --target-type unstructured --address localhost:12332 --verbose --logging-level info`

### running with docker

`drum server --code-dir ./model  --target-type unstructured --address localhost:12332 --verbose --logging-level info --docker ./env`

### Run the example

run an example.  It currently doesn't matter what you sent to the model, it is only returning one prediction as json

```
curl --location --request POST 'localhost:12332/predictUnstructured' \
--header 'Content-Type: text/plain' \
--data-raw 'email_content: "hi gautam"
i can put whatever i want here
{x: 1, y: 3}
123,123,123
'
```

will return 

`{"message":"scoring in an unstrcutrued fashion"}`
