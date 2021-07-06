package kg.easy.easycrm.models.dto;

import lombok.Data;

@Data
public class AuthResponse {

    private boolean success;
    private String message;

    public AuthResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public AuthResponse() {
    }
}
