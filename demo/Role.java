public enum Role {

    MANAGER("����Ա"),

    TEACHER("��ʦ"),

    STUDENT("ѧ��"),
    ;

    private final String description;

    public String getDescription() {
        return description;
    }

    Role(String description) {
        this.description = description;
    }
}
