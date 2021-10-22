# This is the default base image for use with user models and workflows.
FROM datarobot/java-dropin-env-base

# Install the list of core requirements, e.g. sklearn, numpy, pandas, flask.
# **Don't modify this file!**
COPY dr_requirements.txt dr_requirements.txt

# '--upgrade-strategy eager' will upgrade installed dependencies
# according to package requirements or to the latest
RUN pip3 install -U --upgrade-strategy eager --no-cache-dir -r dr_requirements.txt  && \
    rm -rf dr_requirements.txt

RUN apt-get update && apt-get install git make -y && cd /opt && \
    git clone --branch tim/java-unstructured-experiment https://github.com/datarobot/datarobot-user-models.git && \
    cd /opt/datarobot-user-models/custom_model_runner && \
    make && \
    pip3 install -U dist/datarobot_drum-*-py3-none-any.whl

# Copy the drop-in environment code into the correct directory
# Code from the custom model tarball can overwrite the code here
ENV HOME=/opt CODE_DIR=/opt/code ADDRESS=0.0.0.0:8080
ENV DRUM_JAVA_CUSTOM_CLASS_PATH=/opt/model/custom-model-0.1.0.jar
ENV DRUM_JAVA_CUSTOM_PREDICTOR_CLASS=custom.CustomModel
WORKDIR ${CODE_DIR}
COPY ./ ${CODE_DIR}

ENV WITH_ERROR_SERVER=1
# Uncomment the following line to switch from Flask to uwsgi server
#ENV PRODUCTION=1 MAX_WORKERS=1 SHOW_STACKTRACE=1

ENTRYPOINT ["/opt/code/start_server.sh"]
