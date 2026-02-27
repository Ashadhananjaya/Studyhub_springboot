package com.studyhub.studyhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studyhub.studyhub.model.Note;
import com.studyhub.studyhub.model.User;
import com.studyhub.studyhub.repository.NoteRepository;
import com.studyhub.studyhub.repository.UserRepository;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    // ✅ Create Note
    public Note createNote(Long userId, Note note) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        note.setUser(user);
        return noteRepository.save(note);
    }

    // ✅ Get all notes of a user
    public List<Note> getUserNotes(Long userId) {
        return noteRepository.findByUserId(userId);
    }

    // ✅ Get all public notes
    public List<Note> getPublicNotes() {
        return noteRepository.findByIsPublicTrue();
    }
}