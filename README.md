# SHA-2
With digitalization, today anything can be achieved with few clicks. Moreover, today online application systems such as online banking or shopping sites are used by most of the people. However, this has increased the demand of secure systems to protect and store the login credentials. Further, emphasis is required on enhancing the efficiency and quality of existing techniques. Hashing functions ensures that the input message given of any length will produce fixed length of hashed value as the output as given below. For example, a single word or a complete sentence will produce the final output hash value of equal length. Secure Hash Algorithm-2 (SHA-2) is similar to SHA-1 algorithm however, instead of 5 sub-blocks of 32 bits, SHA-2 consists of 8 sub-blocks of 32 bits. SHA-2 algorithm consists of 6 basic hashing functions which produces hashes such as 224, 256, 284, 384 or 512 bits. The research highlights the execution of SHA-2 algorithm and measures the degree of security achieved with the help of this algorithm.

Specific objectives are:

Implementing the SHA2 Algorithm to overcome the drawbacks pertaining to collision in SHA1 and MD5 Algorithms.
Further, the second part of the project is to measure the security provided by SHA2 algorithm which are Security metrics and SMART metrics.

SHA - 2 Algorithm generally consists of 2 of the following stages: 

Pre-processing stage and Hash computation stage. The basic flow of algorithm can be seen below.   

1. Pre-processing Stage:
       A. Padding a message
       B. Parsing the padded message into m-blocks.
       C. Setting initialization values


2. Hash Computation Stage:
      A. Message Schedule
      B. Intermediate hash value computation using   the message schedule, functions, constants.
      C. Append hash values to represent the message digest.

The algorithm takes input message(M) of any length and converts it into 8 bit ASCII equivalent. In preprocessing stage, message is first appended with 1bit and further 0bits are appended for the input message to be of length 256 bit. 

Further, the message is divided into 16 blocks of 32 bits value and H0-H7 hash values are initialized.
 
In our second main Hash computation stage, we generate the message schedule Wt using the equation,

W_t={█(M_t^((i) )@σ_1 (W_(t-2) )+W_(t-7)+σ_0 (W_(t-15) )+W_(t-16) )┤.
  

We initialize the a-h values which contains H0-H7 hash values assigned in the previous preprocessing stage. In SHA2 algorithm we perform 64 rounds of iterations to calculate a-h values. The previous values of a-h is used an input to the next iteration round. So, the output of the first iteration is given as the input to the next iteration round. 

After 64 rounds of iterations using the functions, we get the final a-h values which will be used to calculate the intermediate hash function.  In intermediate hash values, we use the previous set of hash values and the final a-h values received from the 64th iteration round. Now, we get 8 hash values H0-H7 hash values. 

We simply append the 8 block of hash values to generate one block value which is the final hash value. 

Depending on the previous generated hash value, new hash values are generated and passed on to the next iteration.

This algorithm is the only algorithm that consists of 64 rounds of iterative computations giving final hash as the output which is later appended to get the final result.

After all the computation work, this algorithm is ready to be used for comparing input messages to derive decisions of granting a secure access to the users in the system.
