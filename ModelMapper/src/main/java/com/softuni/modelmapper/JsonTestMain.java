package com.softuni.modelmapper;

import com.google.gson.*;
import com.softuni.modelmapper.dtos.AddressDto;
import com.softuni.modelmapper.dtos.CreateEmployeeDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class JsonTestMain implements CommandLineRunner {
    class LocalDateAdapter implements JsonSerializer<LocalDate> {
        public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
    }

    @Override
    public void run(String... args) throws Exception {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("YY-MM-DD")
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (jsonElement, type, jsonDeserializationContext) -> LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString()))
                .setPrettyPrinting()
                .create();

        AddressDto dto = new AddressDto("Yambol");
        String json = gson.toJson(dto);
        System.out.println(json);

        AddressDto dtoFromJson = gson.fromJson("{\"name\":\"Burgas\"}", AddressDto.class);
        System.out.println(dtoFromJson.getName());

        CreateEmployeeDto createEmployeeDto = gson.fromJson("{\"firstName\":\"Gosho\", \"birthday\":\"2020-12-10\"}", CreateEmployeeDto.class);
        System.out.println(gson.toJson(createEmployeeDto));
    }
}
