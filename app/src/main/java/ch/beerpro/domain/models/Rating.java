package ch.beerpro.domain.models;

import com.google.firebase.firestore.Exclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating implements Entity {
    public static final String COLLECTION = "ratings";
    public static final String FIELD_BEER_ID = "beerId";
    public static final String FIELD_USER_ID = "userId";
    public static final String FIELD_LIKES = "likes";
    public static final String FIELD_CREATION_DATE = "creationDate";

    @Exclude
    private String id;
    private String beerId;
    private String beerName;
    private String userId;
    private String userName;
    private String userPhoto;
    private String photo;
    private float rating;
    private String comment;


    /**
     * We use a Map instead of an Array to be able to query it.
     *
     * @see <a href="https://firebase.google.com/docs/firestore/solutions/arrays#solution_a_map_of_values"/>
     */
    private Map<String, Boolean> likes;
    private Date creationDate;


    private String location;
    private ArrayList<String> aroma;

   /* public Rating(String id, String beerId, String beerName, String uid, String userName, String userPhoto, String photo, float rating, String comment, Map<String,Boolean> likes, Date creationDate) {
        this.id = id;
        this.beerId = beerId;
        this.beerName = beerName;
        userId = uid;
        this.userName = userName;
        this.userPhoto = userPhoto;
        this.photo = photo;
        this.rating = rating;
        this.comment = comment;
        this.likes = likes;
        this.creationDate = creationDate;
    }*/

    /*@Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    *//*@Override
    public String getID() {
        return id;
    }*//*

    public String getBeerId() {
        return beerId;
    }*/
}
