package com.trisuliswanto.covid19;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.trisuliswanto.covid19.Models.ResponseCovid19;
import com.trisuliswanto.covid19.MyRetrofit.ApiInterface;
import com.trisuliswanto.covid19.MyRetrofit.ServiceGenerator;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Implementation of App Widget functionality.
 */
public class Covid19 extends AppWidgetProvider {

    RemoteViews views;

    static void updateAppWidget(Context context, final AppWidgetManager appWidgetManager,
                                final int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.covid19);


        // Create a very simple REST adapter which points the GitHub API endpoint.
        ApiInterface client = ServiceGenerator.createService(ApiInterface.class);
        // Fetch and print a list of the contributors to this library.
        Call<List<ResponseCovid19>> call = client.get_covid19_indonesia();

        call.enqueue(new Callback<List<ResponseCovid19>>() {
            @Override
            public void onResponse(Call<List<ResponseCovid19>> call, Response<List<ResponseCovid19>> response) {
                try{
                    List<ResponseCovid19> mResponseCovid19 = response.body();

                    Log.d("RESPONSE", "negara="+mResponseCovid19.get(0).getName());
                    views.setTextViewText(R.id.positif, mResponseCovid19.get(0).getPositif());
                    views.setTextViewText(R.id.sembuh, mResponseCovid19.get(0).getSembuh());
                    views.setTextViewText(R.id.meninggal, mResponseCovid19.get(0).getMeninggal());

                    // Instruct the widget manager to update the widget
                    appWidgetManager.updateAppWidget(appWidgetId, views);
                }
                catch (Exception e){
                    Log.e("ERROR", "Error bro "+ e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<ResponseCovid19>> call, Throwable t) {
                Log.e("ERROR", "Error bro "+ t.getMessage());
            }
        });

    }

    private void get_covid19_indonesia(Context context){

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

