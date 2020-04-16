package cordova.plugin.mathcalculator;

import android.content.Context;
import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class echoes a string called from JavaScript.
 */
public class MathCalculator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
       
        if(action.equals("add")) {
            this.add(args, callbackContext);
            return true;
        }
        return false;
    }

    private void add(JSONArray args, CallbackContext callback) {
        if (args != null) {
            try {

                String p1 = args.getJSONObject(0).getString("param1");

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, "Hi, this is a task sent from my to-do app: " + p1);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

                callback.success("Email sent!");

            } catch(Exception ex) {
                callback.error("Something went wrong" + ex);
            }
        } else {
            callback.error("Please don't pass null value");
        }
    }


   
}
