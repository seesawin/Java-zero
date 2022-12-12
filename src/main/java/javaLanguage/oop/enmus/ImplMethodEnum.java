package javaLanguage.oop.enmus;

public enum ImplMethodEnum {
    ID("A1") {
        @Override
        public String getValue() {
            return super.getValue() + "_" + this.name();
        }

        @Override
        public void setValue(NodeContainer node, String value) {
            super.setValue(node, value + "_{" + this.name() + "}");
        }
    },
    NAME("A2"),
    AGE("A3") {
        @Override
        public String getValue() {
            return super.getValue() + "_" + this.name();
        }
    };

    private String address;

    ImplMethodEnum(String address) {
        this.address = address;
    }

    public String getValue() {
        return this.address + "_get";
    }

    public void setValue(NodeContainer node, String value) {
        node.setValue(value + "_decorate");
    }
}

class NodeContainer {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
