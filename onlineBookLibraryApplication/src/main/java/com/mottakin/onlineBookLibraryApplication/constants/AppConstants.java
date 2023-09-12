package com.mottakin.onlineBookLibraryApplication.constants;

public class AppConstants {
    public static final String TOKEN_SECRET = "MySecretMySecretMySecretMySecretMySecretMySecretMySecretMySecret";
    public static final long EXPIRATION_TIME = 864000000;
    public static final String SIGN_IN = "/user/login";
    public static final String SIGN_UP = "/user/register";
    public static final String USERS_DETAILS = "/users/{userId}";
    public static final String CREATE_BOOKS = "/books/create";
    public static final String UPDATE_BOOKS = "/books/update";
    public static final String DELETE_BOOKS = "/books/delete";
    public static final String SEE_ALL_BOOKS = "/books/all";
    public static final String BORROW_BOOK = "/books/{bookId}/borrow";
    public static final String RETURN_BOOK = "/books/{bookId}/return";
    public static final String SEE_BORROWED_RETURNED_BOOK = "/users/{userId}/books";
    public static final String SEE_ONLY_BORROWED_BOOK = "/users/{userId}/borrowed-books";
    public static final String CREATE_REVIEW = "/books/{bookId}/reviews/create";
    public static final String SEE_REVIEW = "/books/{bookId}/reviews";

    public static final String UPDATE_REVIEW = "/books/{bookId}/reviews/{reviewId}/update";
    public static final String DELETE_REVIEW = "/books/{bookId}/reviews/{reviewId}/delete";

    public static final String HISTORY = "/users/{userId}/history";
    public static final String RESERVE_BOOK = "/books/{bookId}/reserve";
    public static final String CANCLE_RESERVE_BOOK = "/books/{bookId}/reserve";



    public static final String HEADER_STRING = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
}
