## Scala Custom Inference

#### Owner Tim Whittake => timothy.whittaker@datarobot.com

pull my branch of drum tim/java-unstructured-experiment, build it and install it

To run this model with `DRUM` export the following environment variables.  

install the predictor.jar to mvn locall

`export DRUM_JAVA_CUSTOM_CLASS_PATH=/Users/timothy.whittaker/Desktop/git/custom-models-wip/custom_inference/java/unstructured/model/custom-model-0.1.0.jar`

`export DRUM_JAVA_CUSTOM_PREDICTOR_CLASS=custom.CustomModel`

## requirements 

* java 11

you need to build and install the `tim/java-unstructured-experiment` branch of [www.github.com/datarobot-user-models](DRUM).  

Before packaging this with maven, install `predictors.jar` located in the lib folder with 

`mvn install:install-file -Dfile=lib/predictors.jar -DartifactId=drum -DgroupId=com.datarobot -Dversion=1.0.0 -Dpackaging=jar`

Next, set some environment variables for DRUM to find the model. 

export DRUM_JAVA_CUSTOM_CLASS_PATH=/Users/timothy.whittaker/Desktop/git/custom-models-wip/custom_inference/java/unstructured/model/custom-model-0.1.0.jar

export DRUM_JAVA_CUSTOM_PREDICTOR_CLASS=custom.CustomModel

drum server --code-dir ./model  --target-type unstructured --address localhost:12332 --verbose --logging-level info

run and example .  It currently doesn't matter what you sent to the model, i'm only returning one prediction as json

curl --location --request POST 'localhost:12332/predictUnstructured' \
--header 'Content-Type: text/plain' \
--data-raw 'email_content: "hi gautam"
i can put whatever i want here
{x: 1, y: 3}
123,123,123
'
