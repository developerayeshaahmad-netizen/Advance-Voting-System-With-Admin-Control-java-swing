# Advance-Voting-System-With-Admin-Control-java-swing
A Java Swing desktop application for a secure, digital Online Voting System featuring role-based dashboards (Admin/Voter), data persistence using file handling, account recovery, and strict vote validation to prevent duplicate voting.

A desktop-based Online Voting System built using Java Swing for an object-oriented programming (OOP) final project. This application replaces manual, paper-based voting with a clean, secure digital interface that streamlines the voting process, ensures data accuracy, and simplifies election management.

Features:
- **Role-Based Authentication:** A secure login panel (`Authframe`) directs users to either the Admin Panel or the Voter Dashboard depending on their credentials.
- **Voter Dashboard:** Registered voters can view available candidates in a dropdown selector, cast their vote, and receive instant status updates.
- **Prevent Double-Voting:** The system verifies user status before allowing a vote. If a user has already voted, the voting action is locked, and a warning is displayed.
- **Admin Panel:** Admins can securely log in to add new candidates, remove existing candidates, and monitor real-time vote tallies.
- **Smart Password Validation:** Registration rules require strong passwords that must meet a fixed length (7 characters) and include special characters (e.g., `@`, `#`, `$`).
- **Account Recovery:** Features a "Forgot Credentials" workflow where users can look up and recover their account details securely using their unique User ID.
- **Data Persistence:** Implements robust file handling (`Filehandler`) to seamlessly save and load user accounts, candidates, and vote counts across application restarts.

UI & Architecture:
- Built using a structured multi-frame approach (`Main`, `Authframe`, `WelcomeScreen`, `VoterDashboard`).
- Custom user interface design using layouts like `GridLayout` for structured forms and `SpringLayout` for precise dashboard positioning.
- Seamless, visual styling utilizing custom background graphics overlaid with translucent panels (`setOpaque(false)`) for enhanced text readability.
- Multi-threaded 3-second splash screen transition on startup for a professional application feel.
