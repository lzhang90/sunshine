package com.example.lzhang90.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lzhang90 on 3/30/2015.
 */
public class WeatherDataParser {
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex) throws JSONException{
        JSONObject weatherJsonObj=new JSONObject(weatherJsonStr);
        int totalDays=weatherJsonObj.getInt("cnt");
        if(dayIndex<=0 || dayIndex>totalDays)
            throw new JSONException("Out of day index");
        JSONArray days=weatherJsonObj.getJSONArray("list");
        return days.getJSONObject(dayIndex).getJSONObject("temp").getDouble("max");
    }

    public static void main(String[] args){
        //test getMaxTemp
        String jsonStr="{\"cod\":\"200\",\"message\":0.0049,\"city\":{\"id\":5317058,\"name\":\"Tempe\",\"coord\":{\"lon\":-111.909309,\"lat\":33.414768},\"country\":\"US\",\"population\":161719},\"cnt\":7,\"list\":[{\"dt\":1427742000,\"temp\":{\"day\":34.03,\"min\":18.41,\"max\":35.39,\"night\":18.41,\"eve\":33.33,\"morn\":34.03},\"pressure\":976.71,\"humidity\":19,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"speed\":1.82,\"deg\":53,\"clouds\":80},{\"dt\":1427828400,\"temp\":{\"day\":28.59,\"min\":13.25,\"max\":31.53,\"night\":16.89,\"eve\":30.95,\"morn\":13.25},\"pressure\":976.56,\"humidity\":22,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":1.22,\"deg\":119,\"clouds\":0},{\"dt\":1427914800,\"temp\":{\"day\":27.38,\"min\":13.84,\"max\":28.99,\"night\":16.32,\"eve\":28.99,\"morn\":13.84},\"pressure\":959.61,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":5.29,\"deg\":195,\"clouds\":0},{\"dt\":1428001200,\"temp\":{\"day\":25.9,\"min\":11.16,\"max\":27.68,\"night\":12.98,\"eve\":27.68,\"morn\":11.16},\"pressure\":960.53,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":3.37,\"deg\":188,\"clouds\":41},{\"dt\":1428087600,\"temp\":{\"day\":24.91,\"min\":6.66,\"max\":28.08,\"night\":12.61,\"eve\":28.08,\"morn\":6.66},\"pressure\":966.37,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":2.04,\"deg\":42,\"clouds\":3},{\"dt\":1428174000,\"temp\":{\"day\":25.82,\"min\":11.15,\"max\":27.61,\"night\":11.65,\"eve\":27.61,\"morn\":11.15},\"pressure\":960.53,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":1.74,\"deg\":184,\"clouds\":75},{\"dt\":1428260400,\"temp\":{\"day\":25.35,\"min\":10.71,\"max\":25.65,\"night\":18.94,\"eve\":25.65,\"morn\":10.71},\"pressure\":953.85,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":3.87,\"deg\":193,\"clouds\":36}]}";
        try {
            getMaxTemperatureForDay(jsonStr, 1);
        }
        catch (JSONException e){
            e.printStackTrace();
        }

    }
}
