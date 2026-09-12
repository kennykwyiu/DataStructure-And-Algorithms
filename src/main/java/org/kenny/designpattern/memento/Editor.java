package org.kenny.designpattern.memento;

public class Editor {
    private String content;

    public EditorState createState() {
        return new EditorState(content);
    }

    public void restoreState(EditorState state) {
        content = state.getState();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
