package ir.aghakhaniedu.mymvvmdatabinding.viewModel;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private String successMessage = "Login successful";
    private String errorMessage = "Email or Password is not valid";
    private String email = "";
    private String password = "";
    private MutableLiveData<String> toastMessage = new MutableLiveData<>();
    public void isValid() {
        if (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
                && password.length() > 5) {
            toastMessage.setValue(successMessage);
        } else {
            toastMessage.setValue(errorMessage);
        }
    }
    public LiveData<String> getToastMessage() {
        return toastMessage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
