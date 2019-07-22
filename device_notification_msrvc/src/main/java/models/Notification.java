package models;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.UUID;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Field
    @Nullable
    private String userid;

    @Field
    @Nullable
    private String merchantid;

    @Field
    @Nullable
    private  String companyid;

    @Field
    private String id = UUID.randomUUID().toString();

    @Field
    @Nullable
    private String title;

    @Field
    @Nullable
    private  String body;

    @Field
    @Nullable
    private  Boolean seen;

     @Field
    private  String created_on = new Date().toString();



}
