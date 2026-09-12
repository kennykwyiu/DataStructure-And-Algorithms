package org.kenny.designpattern.memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorState> states = new ArrayList<>();

    public void push(EditorState editorState) {
        states.add(editorState);
    }
    
    public EditorState pop() {
        int lastIndex = states.size() - 1;
        EditorState state = states.get(lastIndex);
        states.remove(state);
        return state;
    }
}
