**Games:** id(PK), status, created_at, current_turn_player_id(FK),
**Players:** id(PK), game_id(FK), name
**Boards:** id(PK), player_id (FK), size
**Ships:** id(PK), board_id(FK), type, length(no of cells), sunk(boolean) 
**Cells:** id(PK), row, col, board_id(FK), has_ship, is_hit
**Moves:** id(PK), game_id(FK), player_id(FK)(Who fired), row(target row), col(target col), result(hit / miss)

