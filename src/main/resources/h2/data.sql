insert ignore into oauth_client_details(client_id, resource_ids,client_secret,scope,authorized_grant_types,web_server_redirect_uri,authorities,access_token_validity,refresh_token_validity,additional_information,autoapprove)
values(
       'mycloset',
       null,
       '{bcrypt}$2a$10$Dp7dXcuT5cGW9clQRfJKIe22EVV7rNCjntXWBE6f0e8nPuu6GlRq6',
       'read,write',
       'authorization_code,refresh_token',
       'http://localhost:1995/oauth2/callback',
       'ROLE_USER',
       36000,
       50000,
       null,
       null
    );