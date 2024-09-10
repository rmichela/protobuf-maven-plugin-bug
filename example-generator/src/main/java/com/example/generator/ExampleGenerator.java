package com.example.generator;

import com.google.protobuf.compiler.PluginProtos;
import com.salesforce.jprotoc.Generator;
import com.salesforce.jprotoc.GeneratorException;
import com.salesforce.jprotoc.ProtocPlugin;

import java.util.Collections;
import java.util.List;

public class ExampleGenerator extends Generator {
    public static void main(String[] args) {
        if (args.length == 0) {
            ProtocPlugin.generate(new ExampleGenerator());
        } else {
            ProtocPlugin.debug(new ExampleGenerator(), args[0]);
        }
    }

    @Override
    protected List<PluginProtos.CodeGeneratorResponse.Feature> supportedFeatures() {
        return Collections.singletonList(PluginProtos.CodeGeneratorResponse.Feature.FEATURE_PROTO3_OPTIONAL);
    }

    @Override
    public List<PluginProtos.CodeGeneratorResponse.File> generateFiles(PluginProtos.CodeGeneratorRequest request) throws GeneratorException {
        return List.of(PluginProtos.CodeGeneratorResponse.File.newBuilder()
                .setName("example.txt")
                .setContent("Hello, world!")
                .build());
    }
}
