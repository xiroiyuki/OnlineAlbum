package cn.fc.bean;

public class RoleAuthority {
    private long id;
    private Role role;
    private Authority authority;

    @Override
    public String toString() {
        return "RoleAuthority{" +
                "id=" + id +
                ", role=" + role +
                ", authority=" + authority +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
