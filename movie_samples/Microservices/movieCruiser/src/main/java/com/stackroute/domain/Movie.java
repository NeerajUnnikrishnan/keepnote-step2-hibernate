package com.stackroute.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

        @Id
        int id;

        @NotNull
        @Size(min = 1, max = 60)
        String movieName;

        @NotNull
        @Min(1)
        int rating;

        @NotNull
        @Size(min = 1, max = 250)
        String comments;

}
