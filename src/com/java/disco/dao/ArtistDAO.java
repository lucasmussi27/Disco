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

    public List<ArtistDTO> read() {
        String sql = "select * from artist";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ArtistDTO> list = new ArrayList<>();
        try {
            stmt = this.conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()) {
                ArtistDTO a = new ArtistDTO();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setGenre(rs.getString("genre"));
                list.add(a);
            }
        } catch(SQLException se) {
            System.err.println(se.getCause());
            System.err.println(se.getMessage());
        }
        return list;
    }

    public void update(ArtistDTO art) {
        String sql = "update artist set name = ?, genre = ? where id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, art.getId());
            stmt.setString(2, art.getName());
            stmt.setString(3, art.getGenre());
            stmt.executeUpdate();
        } catch(SQLException se) {
            System.err.println(se.getCause());
            System.err.println(se.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "delete artist where id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch(SQLException se) {
            System.err.println(se.getCause());
            System.err.println(se.getMessage());
        }
    }
}