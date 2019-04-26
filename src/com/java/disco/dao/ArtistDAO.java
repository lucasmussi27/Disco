package com.java.disco.dao;

import java.sql.*;
import java.util.*;
import com.java.disco.dto.ArtistDTO;

public class ArtistDAO {
    private Connection conn;

    public ArtistDAO() {
        this.conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true");
    }

    public void create(ArtistDTO art) {
        String sql = "insert into artist values (?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, stmt.getGeneratedKeys());
            stmt.setString(2, art.getName());
            stmt.setString(3, art.getGenre());
            stmt.executeUpdate();
        } catch(SQLException se) {
            System.err.println(se.getCause());
            System.err.println(se.getMessage());
        }
    }

    public List<ArtistDTO> read() {}

    public void update() {}

    public void delete() {}
}