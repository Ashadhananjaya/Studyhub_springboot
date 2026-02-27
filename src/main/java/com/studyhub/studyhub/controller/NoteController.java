package com.studyhub.studyhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studyhub.studyhub.model.Note;
import com.studyhub.studyhub.service.NoteService;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // ✅ Create Note
    // For now we pass userId manually (later JWT will handle it)
    @PostMapping("/{userId}")
    public Note createNote(@PathVariable Long userId, @RequestBody Note note) {
        return noteService.createNote(userId, note);
    }

    // ✅ Get all notes of a user
    @GetMapping("/my/{userId}")
    public List<Note> getUserNotes(@PathVariable Long userId) {
        return noteService.getUserNotes(userId);
    }

    // ✅ Get all public notes
    @GetMapping("/public")
    public List<Note> getPublicNotes() {
        return noteService.getPublicNotes();
    }
}