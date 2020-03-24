package com.trisuliswanto.covid19;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.trisuliswanto.covid19.Models.ResponseCovid19;
import com.trisuliswanto.covid19.Models.ResponseCovid19id;
import com.trisuliswanto.covid19.MyRetrofit.ApiInterface;
import com.trisuliswanto.covid19.MyRetrofit.ServiceGenerator;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Implementation of App Widget functionality.
 */
public class Covid19 extends AppWidgetProvider {

    static void updateAppWidget(Context context, final AppWidgetManager appWidgetManager,
                                final int appWidgetId) {

//        CharSequence widgetText = context.getString(R.string.appwidget_text);
//        // Construct the RemoteViews object
//        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.covid19);
//        // Create a very simple REST adapter which points the GitHub API endpoint.
//        ApiInterface client = ServiceGenerator.createService(ApiInterface.class);
//        // Fetch and print a list of the contributors to this library.
//        Call<List<ResponseCovid19>> call = client.get_covid19_indonesia();
//
//        call.enqueue(new Callback<List<ResponseCovid19>>() {
//            @Override
//            public void onResponse(Call<List<ResponseCovid19>> call, Response<List<ResponseCovid19>> response) {
//                try{
//                    List<ResponseCovid19> mResponseCovid19 = response.body();
//
//                    Log.d("RESPONSE", "lastupdate="+mResponseCovid19.get(0).getLastupdate());
//                    views.setTextViewText(R.id.positif, mResponseCovid19.get(0).getPositif());
//                    views.setTextViewText(R.id.sembuh, mResponseCovid19.get(0).getSembuh());
//                    views.setTextViewText(R.id.meninggal, mResponseCovid19.get(0).getMeninggal());
//
//                    // Instruct the widget manager to update the widget
//                    appWidgetManager.updateAppWidget(appWidgetId, views);
//                }
//                catch (Exception e){
//                    Log.e("ERROR", "Error bro "+ e.getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<ResponseCovid19>> call, Throwable t) {
//                Log.e("ERROR", "Error bro "+ t.getMessage());
//            }
//        });


        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.covid19id);
        // Create a very simple REST adapter which points the GitHub API endpoint.
        ApiInterface client = ServiceGenerator.createService(ApiInterface.class);
        // Fetch and print a list of the contributors to this library.
        Call<ResponseCovid19id> call = client.get_covid19id_indonesia();
        call.enqueue(new Callback<ResponseCovid19id>() {
            @Override
            public void onResponse(Call<ResponseCovid19id> call, Response<ResponseCovid19id> response) {
                try{
                    ResponseCovid19id mResponseCovid19id = response.body();
                    Log.d("RESPONSE", "lastupdate="+mResponseCovid19id.getMetadata().getLastUpdatedAt());
                    views.setTextViewText(R.id.positif, String.valueOf(mResponseCovid19id.getConfirmed().getValue()));
                    views.setTextViewText(R.id.perawatan, String.valueOf(mResponseCovid19id.getActiveCare().getValue()));
                    views.setTextViewText(R.id.sembuh, String.valueOf(mResponseCovid19id.getRecovered().getValue()));
                    views.setTextViewText(R.id.meninggal, String.valueOf(mResponseCovid19id.getDeaths().getValue()));

                    String last_upd = mResponseCovid19id.getMetadata().getLastUpdatedAt();
                    Calendar cal= Calendar.getInstance();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault());
                    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
                    cal.setTime(dateFormat.parse(last_upd));
                    cal = dateFormat.getCalendar();

                    String last_updated = cal.get(Calendar.DAY_OF_MONTH)+" "+SharedPref.NAMA_BULAN[cal.get(Calendar.MONTH)]+" "+cal.get(Calendar.YEAR)+" "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE);

                    views.setTextViewText(R.id.last_updated, "Last Updated "+last_updated);

                    Log.d("RESPONSE", "Last Updated="+last_updated);
                    // Instruct the widget manager to update the widget
                    appWidgetManager.updateAppWidget(appWidgetId, views);
                }
                catch (Exception e){
                    Log.e("ERROR", "Error bro "+ e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseCovid19id> call, Throwable t) {
                Log.e("ERROR", "Failure Error bro "+ t.getMessage());
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

