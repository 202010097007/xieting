public enum Role {

    MANAGER("管理员"),

    TEACHER("老师"),

    STUDENT("学生"),
    ;

    private final String description;

    public String getDescription() {
        return description;
    }

    Role(String description) {
        this.description = description;
    }
}
