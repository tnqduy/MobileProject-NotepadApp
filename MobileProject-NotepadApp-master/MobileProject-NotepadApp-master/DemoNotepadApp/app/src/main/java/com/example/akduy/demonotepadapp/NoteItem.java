package com.example.akduy.demonotepadapp;

/**
 * Created by Trần NQ Duy on 5/22/16.
 */
public class NoteItem {
    private String _title;
    private String _content;

    public NoteItem(String title, String content) {
        this._title = title;
        this._content = content;
    }

    public String get_title() {
        return _title;
    }

    public String get_content() {
        return _content;
    }
}
