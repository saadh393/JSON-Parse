# JSON Parse | Android | Java
 

JSON stands for JavaScript Object Notation. It is structured, lightweight, human-readable and easy to parse. It's the best alternative to XML when our android app needs to interchange data from the server. XML parsing is very complex as compare to JSON parsing.
First, We have to understand how JSON works. JSON contains Objects, Arrays and key and value. An object is represented by Curly Braces: "{}", Array is represented by Square Brackets: "[]"
Everything between curly braces :{} is called JSON Object & everything between square brackets : [] is a JSON Object. A JSON object can contain different key-value pairs. The value of a key can be an Array. And Array may contain different Objects. And Multiple objects are separated by a comma. Seems difficult?

No, It's not. See the Sample JSON file which will help you to understand it by your own and we will use this to fetch data. This JSON file is hosted on https://api.myjson.com/bins/xcuq8
Simple JSON ValueSo, We will learn how you can parse JSON data easily in your app. To do so we will use a simple android Library Called Volley.
To Implement that library Go to your app build.gradle file and paste the library.
com.android.volley:volley:1.1.1
It seems like this :-
Implementing Volley LibraryNow let's move on to the Activity class. Let's see the Source code -
RequestQueue mRequstQu;
mRequstQu = Volley.newRequestQueue(MainActivity.this);
String url = "https://api.myjson.com/bins/xcuq8";
JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
    @Override
    public void onResponse(JSONObject response) {
        try {
            JSONArray movie = response.getJSONArray("Movie");

            for(int i = 0; i < movie.length(); i++){
                JSONObject item = movie.getJSONObject(i);
                Log.d("123as123", "Result: \n"
                        +item.getString("Name")+"\n"+
                        item.getInt("Year")+"\n"+
                        item.getDouble("Rating"));
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {

    }
});


mRequstQu.add(request);
Here 'request' variable contains the whole JSON Object. From that object lets get the array of "Movie" by this
JSONArray movie = response.getJSONArray("Movie");
Now 'movie' contains the array of multiple objects. Let's see if we try to print 'movie' in our logcat how it looks :
Now we will fetch values from movie into a so-called JSONObject variable named 'item' into a for loop. So that we can get the values from the object.
Now we will see how the result seems :
Got it !! We get the values from the JSON. Pretty easy. Hope You have't face any problem. You also able to find more information from the official documentation here : https://developer.android.com/training/volley/
