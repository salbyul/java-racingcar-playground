package racing;

public class Name {

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateNoName(name);
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private void validateNoName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("이름이 존재해야 합니다.");
        }
    }
}