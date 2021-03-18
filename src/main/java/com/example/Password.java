package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Password {

    public String password;

    private boolean hasNumber() {
        return this.password.matches(".*\\d.*");
    }

    private boolean hasUppercase() {
        return this.password.matches(".*[A-Z].*");
    }

    private boolean hasLowercase() {
        return this.password.matches(".*[a-z].*");
    }

    private boolean hasSpecialCharacters() {
        return this.password.matches(".*[!@#$%^&*()-+].*");
    }

    private boolean hasDuplicate() {
        AtomicBoolean isDuplicate = new AtomicBoolean(false);
        List<Integer> noDuplicate = new ArrayList<>();
        this.password.codePoints().forEach(character -> {
            if(noDuplicate.contains(character)) {
                isDuplicate.getAndSet(true);
            } else {
                noDuplicate.add(character);
            }
        });
        return isDuplicate.get();
    }

    private boolean hasBackSpace() {
        return this.password.matches(".* .*");
    }

    public boolean isValid() {
        return password.length() > 9
                && hasNumber()
                && hasLowercase()
                && hasUppercase()
                && hasSpecialCharacters()
                && !hasDuplicate()
                && !hasBackSpace();
    }

}
