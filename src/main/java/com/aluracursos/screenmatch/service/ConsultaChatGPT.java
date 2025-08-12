package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obtenerTraduccion(String texto) {
        OpenAiService service = new OpenAiService("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");


        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduce a español el siguiente texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();
    }
}
