package skylink.pkg.Validators;

public class ValidateNumber extends Validator {
    @Override
    public Boolean validateData(String string) {
        return string != null && string.matches("\\d+");
    }
}