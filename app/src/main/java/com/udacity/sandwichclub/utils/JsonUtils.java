package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject nameObject = object.getJSONObject("name");

            sandwich.setMainName(nameObject.getString("mainName"));
            JSONArray alsoKnownAsJsonArray = nameObject.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
                alsoKnownAs.add(alsoKnownAsJsonArray.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownAs);
            sandwich.setPlaceOfOrigin(object.getString("placeOfOrigin"));
            sandwich.setDescription(object.getString("description"));
            sandwich.setImage(object.getString("image"));
            JSONArray ingredientsJsonArray = object.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientsJsonArray.length(); i++) {
                ingredients.add(ingredientsJsonArray.getString(i));
            }
            sandwich.setIngredients(ingredients);
        } catch (JSONException exception) {
            exception.printStackTrace();
        }
        return sandwich;
    }
}
