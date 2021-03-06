# DEMO JIB plugin
This project is a simple spring-boot project which aim is to illustrate how **jib** plugin works. 

Jib is a tool from Google which **creates Docker images** in an easy and fast way avoiding the need to create a Docker file.

Jib separates the application into multiple layers, splitting dependencies from classes. So, each time a change is made in the application is no need for Docker to rebuild the entire Java application - just deploy the layers that changed.

This plugin generates a docker image for our project locally or in a repository depending on the configuration. Then, we just have to set up a container with that image and we have the app running.

More information about jib plugin is available in the following links:

https://github.com/GoogleContainerTools/jib

## Run demo application locally
```mvn clean install```

List the docker images and select the one that has a tag and the name you gave to your image:

```docker images```

Set up a container with the created image:

```docker run -p 8080:8080 -d your_image```

Then when you run localhost:8080 you will see a table filled with books data.

## Additional information
How it works: https://cloud.google.com/java/getting-started/jib

Configuration tutorial: https://dzone.com/articles/create-fast-and-easy-docker-images-with-jib

## Housekeeping
You can use one of the following docker commands in order to clean old and untagged images:

```docker rmi image_name```

Or remove all the dangling images (no more related with any tagged image):

```docker rmi $(docker images -q -f dangling=true)```
