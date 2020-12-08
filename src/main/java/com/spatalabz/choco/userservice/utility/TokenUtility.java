package com.spatalabz.choco.userservice.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public class TokenUtility {

    private static String Token="rohan";


    public String generateToken(String customer_id) {

        Algorithm algorithm = null;

        try {
            algorithm = Algorithm.HMAC256(Token);
        } catch (IllegalArgumentException  e) {

            e.printStackTrace();
        }


        String token = JWT.create()
                .withClaim("customer_Id", customer_id)
                //token active for 5 minutes
                .withExpiresAt(Date.from(Instant.now().plusSeconds(30000)))
                .sign(algorithm);

        return token;
    }

    public String decodeToken(String token) {

        String customer_Id;
       //here verify the given token's algorithm

        Verification verification = JWT.require(Algorithm.HMAC256(Token));

        JWTVerifier jwtverifier = verification.build();
        DecodedJWT decodedjwt = jwtverifier.verify(token);
        Claim claim = decodedjwt.getClaim("customer_Id");
        customer_Id = claim.asString();
        return customer_Id;
    }
}
