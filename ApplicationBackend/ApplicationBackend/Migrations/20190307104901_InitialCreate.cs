using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;

namespace ApplicationBackend.Migrations
{
    public partial class InitialCreate : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "ClubModelClass",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    TeamName = table.Column<string>(nullable: false),
                    ClubValue = table.Column<double>(nullable: false),
                    HomeKitColour = table.Column<string>(nullable: false),
                    AwayKitColour = table.Column<string>(nullable: false),
                    ThridKitColour = table.Column<string>(nullable: true),
                    PremierLeague = table.Column<int>(nullable: false),
                    ChampionsLeague = table.Column<int>(nullable: false),
                    FaCup = table.Column<int>(nullable: false),
                    EuropaLeague = table.Column<int>(nullable: false),
                    LeagueCup = table.Column<int>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_ClubModelClass", x => x.Id);
                });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "ClubModelClass");
        }
    }
}
