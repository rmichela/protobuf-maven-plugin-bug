# protobuf-maven-plugin compile bug

While writing a custom Java protoc generator, I'd like to be able to use the `protobuf-maven-plugin` to compile my
proto files and test the generator. However, I'm running into an issue where the plugin is not able to find my custom 
generator class when using `mvn compile`.

This is the minimal example to reproduce https://github.com/ascopes/protobuf-maven-plugin/issues/358

## Steps to reproduce

1. Clone this repository
2. Run `mvn compile`

## Expected behavior   

The build succeeds and generates `generated-sources/protobuf/example.txt`

## Actual behavior

```
[WARNING] Error: Invalid or corrupt jarfile /Users/.../protobuf-maven-plugin-bug/example-generator/target/classes
[WARNING] --OQqTKNpNTvkQFm-nicKf-uaFLZg_out: protoc-gen-OQqTKNpNTvkQFm-nicKf-uaFLZg: Plugin failed with status code 1.
[ERROR] protoc returned exit code 1 (error) after 175ms
```

## Additional notes

* The protobuf-maven-plugin works as expected when running `mvn package`
* Adding an optional `<mainClass>` parameter to the plugin configuration could provide a way to specify the main class
  when running `mvn compile` for the purposes of Java protoc generator development
