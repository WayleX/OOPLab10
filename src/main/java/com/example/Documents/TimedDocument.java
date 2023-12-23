package com.example.Documents;

import java.util.concurrent.TimeUnit;

public class TimedDocument implements Document {
    private Document document;

    public TimedDocument(Document document) {
        this.document = document;
    }

    @Override
    public String parse() {
        long startTime = System.nanoTime();
        String parsedContent = document.parse();
        long endTime = System.nanoTime();

        long elapsedTimeInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("Parsing time: " + elapsedTimeInMillis + "ms");
        
        return parsedContent;
    }
}
