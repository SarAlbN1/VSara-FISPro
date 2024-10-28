package com.teamconect.dtos;

public class UsuarioRolDTO {
    private String userId;
    private String rolId;
    private String departamentoId;

    public UsuarioRolDTO() {}

    public UsuarioRolDTO(String userId, String rolId, String departamentoId) {
        this.userId = userId;
        this.rolId = rolId;
        this.departamentoId = departamentoId;
    }

    // Getters y Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getRolId() { return rolId; }
    public void setRolId(String rolId) { this.rolId = rolId; }

    public String getDepartamentoId() { return departamentoId; }
    public void setDepartamentoId(String departamentoId) { this.departamentoId = departamentoId; }
}
